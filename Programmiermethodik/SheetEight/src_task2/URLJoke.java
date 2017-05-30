import java.io.IOException;
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
            System.out.println("An IO error has occurred, returning \"\"");
            return "";
        }
    }

    private String loadJokeFromURL(String urlString) throws NoJokeFoundException {
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
            throw new NoJokeFoundException();
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
            System.out.println("Some kind of error has occurred...");
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
        if ((number > bound) || (number < 0)) {
            throw new NoJokeFoundException();
        }

    return loadJokeFromURL("http://api.icndb.com/jokes/" + number);
    }

    public static void main(String[] args) throws NoJokeFoundException {
        URLJoke joke = new URLJoke();
        // System.out.println(joke.readURL("http://api.icndb.com/jokes/random"));
        joke.loadJokeFromURL("http://api.icndb.com/jokes/random");
        joke.jokeWithNumber(1);
    }

    private static class NoJokeFoundException extends Exception {
        private NoJokeFoundException() {
            System.out.println("I could not find any jokes...");
        }
    }
}
