import bdtc.lab1.CounterType;
import bdtc.lab1.HW1Mapper;
import calculate.Calculate;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.junit.Before;
import org.junit.Test;
import parser.CoordinateParser;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class CountersTest {

    private MapDriver<LongWritable, Text, Text, IntWritable> mapDriver;

    private final String testMalformedIP = "mama mila ramu ghjhghj";
    private final String testIP = "13 24 43243 432432\"\n";

    @Before
    public void setUp() {
        HW1Mapper mapper = new HW1Mapper();
        mapDriver = MapDriver.newMapDriver(mapper);
    }

    @Test
    public void testMapperCounterOne() throws IOException  {
        mapDriver
                .withInput(new LongWritable(), new Text(testMalformedIP))
                .runTest();
        assertEquals("Expected 1 counter increment", 1, mapDriver.getCounters()
                .findCounter(CounterType.MALFORMED).getValue());
    }

    @Test
    public void testMapperCounterZero() throws IOException {
        CoordinateParser parser = CoordinateParser.parseCoordinate(testIP);

        mapDriver
                .withInput(new LongWritable(), new Text(testIP))
                .withOutput(new Text(Calculate.calculateArea(parser.getX(), parser.getY())),
                        new IntWritable(1))
                .runTest();
        assertEquals("Expected 1 counter increment", 0, mapDriver.getCounters()
                .findCounter(CounterType.MALFORMED).getValue());
    }

    @Test
    public void testMapperCounters() throws IOException {
        CoordinateParser parser = CoordinateParser.parseCoordinate(testIP);
        mapDriver
                .withInput(new LongWritable(), new Text(testIP))
                .withInput(new LongWritable(), new Text(testMalformedIP))
                .withInput(new LongWritable(), new Text(testMalformedIP))
                .withOutput(new Text(Calculate.calculateArea(parser.getX(), parser.getY())), new IntWritable(1))
                .runTest();

        assertEquals("Expected 2 counter increment", 2, mapDriver.getCounters()
                .findCounter(CounterType.MALFORMED).getValue());
    }
}

