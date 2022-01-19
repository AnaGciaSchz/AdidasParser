package src.model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Product {
    private String id;
    private String sku;
    private String name;
    private String url;
    private String price;
    private String original_price;
    private String availability;
    private String color;
    private String source;
    private String source_website;
    private String categories;
    private String description;
    private String[] images;
    private String average_rating;
    private String baseQuery_bot;
    private String modificator_bot;
    private String stock_availabitliy;
    private String previous_sales;
    private String newness;

    private Random rand = new Random();

    static final List<String> queries = Arrays.asList("shoes","pants", "shorts", "tiro 21", "top", "socks", "nmd"
            ,"boots","tank top", "hat", "jacket","sneakers", "stan smith", "superstar","t shirt", "t-shirt", "shirt",
            "primegreen", "pants", "sweatshirt", "bag","yeezy", "sportswear", "slides", "hoodie", "ultraboost",
            "backpack", "samba", "hat", "joggers", "sweatpants", "cloudfoam", "jacket", "gazelle", "track suit",
            "sandals", "alexander wang", "scarpe", "ozweego", "swift", "stella mccartney", "continental", "collar", "knee support",
            "wrist band", "polo", "tracksuit", "powerlift", "cap", "terrex", "superstar 11", "nizza 11", "trainers", "command",
            "vest", "canvas 11", "jersey", "headguard", "yeezy 350", "yeezy 700", "spezial", "yeezy 500", "zx 750", "yeezy slides",
            "ultra boost", "continental 80", "tiro 19", "beanie", "alphaskin", "bags", "pant", "jabulani", "jeremy scott", "hercules",
            "nastase", "decade", "neo", "conductor", "energy boost", "swimsuit", "crazy explosive", "springblade", "geezy",
            "geesy", "cloud", "powerlift 3.1", "seeley", "drake jones", "high top", "nmd pk", "barricade", "gloves", "snapback",
            "sandal","deo", "flip flops", "flip flop", "bape x", "hockey stick", "anti perspirant", "caps", "match ball", "ball",
            "agora 1.0", "sc premiere", "gripper", "ultra tech", "trainer", "crop top", "d rose", "derrik rose", "boxing gloves",
            "collegiate", "new", "neo shoes", "see through jacket", "fashion sneaker", "purecontrol", "equipment", "bomber jacket",
            "mini ball", "leggings", "sticker", "bermuda", "zx750", "windbreaker", "ts lightswitch", "r1", "spezial", "match ball",
            "soccer cleats", "eqt 9317", "argentina jersey messi", "argentina jersey", "adissage sandal", "disney", "adicross",
            "polo shirt", "formotion", "6 pairs", "2 pairs", "sculpt tights", "marvel", "logo dress", "logo shirt", "logo",
            "best version of myself", "full-zip hoodie", "futurenatural", "future natural", "marvel superhero", "superhero",
            "sherpa jacket", "feelready", "aeroready", "french terry", "fluidflash", "tr21", "training bra", "bra", "zoe saldana",
            "feelbrilliant", "low cut socks", "3 pairs", "zx 1k boost shoes", "x9000l3", "loungewear", "cargo pants", "cropped hoodie",
            "plus size", "swim shorts", "dna", "bryony shoes", "postmove shoes", "ozelia", "marimekko", "adidas", "predator",
            "tee", "long sleeve tee", "short sleeve tee", "designed to move", "supernova +","waist bag", "gender neutral", "lego",
            "adidas x", "star wars", "shopper bag", "lunch bag", "bra top", "kevin lyons", "originals x", "set", "case",
            "iphone x", "real madrid", "scarf"); //200
    static final List<String> modificators = Arrays.asList("stripes", "beach", "sport", "deportive", "mountain", "bike",
            "competition", "climbing", "camo-print", "marvel", "sherpa", "yoga", "racer", "marathon", "small", "big",
            "running", "supernova", "plus size", "women", "for men", "originals", "basketball", "jamer harden", "new", "runner",
            "for women", "womens", "mens", "duffel", "skate", "skateboarding", "nite", "falcon", "football", "shiny", "satin",
            "game", "classic", "zebra", "adicolor", "adilette", "cool", "golf", "off court", "power perfect", "california", "kids",
            "solar", "weightlifting", "bucket", "city", "bottoms", "active bodies", "vintage", "futurecarft", "martial arts", "adilux",
            "adizero", "messi", "junior", "foam", "unisex", "badminton", "duffle", "pack", "stripe", "new york", "galactic", "baby",
            "laceless", "slip on", "low cut", "campus", "special edition", "boston","casual", "casual stylish","", "ladies",
            "design", "school", "country", "striped", "cycling", "taekwondo", "cotton", "retro", "cozy", "camo", "spikeless",
            "broken-stripe", "loose", "shower", "3-stripes", "high-waist", "printed", "woven", "maternity", "tensor run", "funny",
            "eco"); //101

    public Product(String sku, String name, String url, String price,
                   String original_price, String availability, String color, String source,
            String source_website, String categories, String description, String[] images,
                   String average_rating) {
        boolean isNew = rand.nextInt(100)<10;
        this.id = generateId();
        this.sku = sku;
        this.name = isNew?"[NEW] "+name:name;
        this.url = url;
        this.price = price;
        this.original_price = original_price;
        this.availability = availability.equals("InStock")?"true":"false";
        this.color = color;
        this.source = source;
        this.source_website = source_website;
        this.categories = categories;
        this.description = description;
        this.images = images;
        this.average_rating = average_rating;
        this.baseQuery_bot = getRandomElement(queries);
        this.modificator_bot = getRandomElement(modificators);
        this.stock_availabitliy = String.valueOf(rand.nextInt(200));
        this.previous_sales = String.valueOf(rand.nextInt(620)+80);
        this.newness = isNew?"true":"false";

    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }

    private String getRandomElement(List<String> list) {
        return list.get(rand.nextInt(list.size()));
    }

    private String deleteSymbol(String word, String symbol){
        return word.replace(symbol,"");
    }

    @Override
    public String toString() {
    return "\n{ \"id\": \""+deleteSymbol(id,"\"")+"\",\n\"language\": \"en\",\n\"country\": \"USA\",\n\"sku\": \""+deleteSymbol(sku,"\"")+"\",\n\"name\": \""
            +deleteSymbol(name,"\"")+ "\",\n\"url\": \""+deleteSymbol(url,"\"")+"\",\n\"price\": \""+price+"\",\n\"original_price\": \""+deleteSymbol(original_price,"$")+
            "\",\n\"availability\": \""+deleteSymbol(availability,"\"")+"\",\n\"color\": \""+deleteSymbol(color,"\"")+"\",\n\"source\": \""+deleteSymbol(source,"\"")+
            "\",\n\"source_website\": \""+deleteSymbol(source_website,"\"")+"\",\n\"categories\": \""+deleteSymbol(categories,"\"")+
            "\",\n\"description\": \""+deleteSymbol(deleteSymbol(description,"\""),"\n")+"\",\n\"images\":[\n \""+deleteSymbol(images[0],"\"")+"\"\n],\n\"average_rating\": \""
            +deleteSymbol(average_rating,"\"")+"\",\n\"newness\":\""+newness+"\",\n\"stock_level\":\""+stock_availabitliy+"\",\n\"unit_sales\": \""+previous_sales+
            "\",\n\"baseQuery_bot\": \""+deleteSymbol(baseQuery_bot,"\"")+"\",\n\"modificator_bot\": \""+deleteSymbol(modificator_bot,"\"")+
            "\"\n}";
    }
}
