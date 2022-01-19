package src;

import src.parser.AdidasCsvParser;
import java.io.IOException;

public class Main {

 public static void main(String[] args) {
  try {
   AdidasCsvParser adidasParser = new AdidasCsvParser();
   adidasParser.parse("csv/adidas_tsv.tsv");
  } catch (IOException e) {
   System.out.println("There was an error: " + e.getMessage());
  }
 }
}