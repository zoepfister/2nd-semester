import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by clemenspfister on 29/05/2017.
 */

public class URLJoke {

    private String readURL(String urlString){
        String out;
        try {
            out = new Scanner(new URL(urlString).openStream(), "UTF-8").useDelimiter("\\A").next();
            return out;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    private String loadJokeFromURL(String urlString){
        String json = readURL(urlString);
        String joke = "";
        try {
            Pattern re = Pattern.compile("\"joke\": \"([^\"]*)\"");
            Matcher matcher = re.matcher(json);
            while (matcher.find()) {
                System.out.println(matcher.group());
                joke += matcher.group();
            }
        } catch (Exception e){
            try {
                throw new NoJokeFoundException();
            } catch (NoJokeFoundException e1) {
                e1.printStackTrace();
            }
        }
        // System.out.println(joke);
        return joke;
    }

    String randomJoke(){
        URLJoke joke = new URLJoke();
        String randomJoke = "";
        try {
            randomJoke = joke.loadJokeFromURL("http://api.icndb.com/jokes/random");
        } catch (Exception e) {
            e.printStackTrace();
        }
         return randomJoke;
    }

    private String jokeWithNumber(int number) throws NoJokeFoundException {
        URLJoke joke = new URLJoke();
        String count = readURL("http://api.icndb.com/jokes/count");
        String value = "";
        Pattern re = Pattern.compile("[0-9]");
        Matcher matcher = re.matcher(count);
        while (matcher.find()){
            value += matcher.group();
        }
        int bound = Integer.parseInt(value);
        if (number > bound){
            throw new NoJokeFoundException();
        }

    return loadJokeFromURL("http://api.icndb.com/jokes/" + number);
    }

    public static void main(String[] args) {
        URLJoke joke = new URLJoke();
        // System.out.println(joke.readURL("http://api.icndb.com/jokes/random"));
        joke.loadJokeFromURL("http://api.icndb.com/jokes/random");
        try {
            joke.jokeWithNumber(2);
        } catch (NoJokeFoundException e) {
            e.printStackTrace();
        }
    }

    private static class NoJokeFoundException extends Exception {
        private NoJokeFoundException() {
        }
    }
}
