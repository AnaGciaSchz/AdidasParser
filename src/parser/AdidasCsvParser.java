package src.parser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import src.model.Product;

public class AdidasCsvParser {

    private Pattern pattern;

    public AdidasCsvParser() {
        this.pattern = Pattern.compile("\t");
    }

    private double trunc(double value) {
        return value<0 ? Math.ceil(value) : Math.floor(value);
    }

    public void parse(String csvFile) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(csvFile));) {
            List<Product> products = in
                    .lines()
                    .skip(1)
                    .map(line -> {
                        String[] x = pattern.split(line);
                            String sku = x[2];
                            String name = x[1];
                            String url = x[0];
                            String price = x[3];
                            String original_price = x[4];
                            if(original_price.equals("0")){
                                original_price="";
                            }
                            String availability = x[6];
                            String color = x[7].toLowerCase(Locale.ROOT);
                            if(color.equals("burgundy") || color.equals("multicolor") || color.equals("multi")){
                                color = "red";
                            }
                            if(color.equals("gold")){
                                color = "yellow";
                            }
                            if (color.equals("silver")){
                                color = "grey";
                            }
                            if(color.equals("turquoise")){
                                color = "blue";
                            }
                            if(color.equals("beige")){
                                color= "white";
                            }
                            String source = x[9];
                            String source_website = x[10];
                            String categories = x[11];
                            String description = x[12];
                            String[] images = x[14].split("~");
                            String average_rating = String.valueOf((trunc(Float.parseFloat(x[17])))).split("\\.")[0];

                            return new Product(sku, name, url, price, original_price,
                                    availability, color, source, source_website, categories, description,
                                    images, average_rating);
                    })
                    .collect(Collectors.toList());

            FileWriter myWriter = new FileWriter("/Users/anamariagarciasanchez/Desktop/ParseAdidasCSV/csv/adidas.json");
            myWriter.write("[");
            int contador = 0;
            for (Product p : products) {
                if(p!=null){
                    myWriter.write(p.toString());
                    contador++;
                }
            }
            myWriter.write("\n]");
            myWriter.close();
            System.out.println("Productos: "+contador);
        }
    }
}