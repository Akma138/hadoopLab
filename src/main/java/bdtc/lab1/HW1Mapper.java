package bdtc.lab1;

import calculate.Calculate;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import parser.CoordinateParser;

import java.io.IOException;


public class HW1Mapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        CoordinateParser coordinate = CoordinateParser.parseCoordinate(line);
        if (coordinate.getX() == -1 || coordinate.getY() == -1) {
            context.getCounter(CounterType.MALFORMED).increment(1);
        } else {
            String areaName = Calculate.calculateArea(coordinate.getX(), coordinate.getY());
            word.set(areaName);
            context.write(word, one);
        }
    }
}
