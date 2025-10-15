import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class LowercaseSentenceTokenizerTest {

    // Wave 1
    @Test
    void testTokenizeWithNoCapitalizationOrPeriod() {
        LowercaseSentenceTokenizer tokenizer = new LowercaseSentenceTokenizer();
        Scanner scanner = new Scanner("this is a lowercase sentence without a period");
        List<String> tokens = tokenizer.tokenize(scanner);

        assertEquals(List.of("this", "is", "a", "lowercase", "sentence", "without", "a", "period"), tokens);
    }

    // Wave 2
    
    @Test
    void testTokenizeWithManySpaces() {
        LowercaseSentenceTokenizer tokenizer = new LowercaseSentenceTokenizer();
        Scanner scanner = new Scanner("this                 is                          a  lowercase                                            sentence  with many  spaces");
        List<String> tokens = tokenizer.tokenize(scanner);

        assertEquals(List.of("this", "is", "a", "lowercase", "sentence", "with", "many", "spaces"), tokens);
    }
    

    // Wave 3
    @Test
    void testTokenizeWithCapitalization() {
        LowercaseSentenceTokenizer tokenizer = new LowercaseSentenceTokenizer();
        Scanner scanner = new Scanner("This is a SENTENCE with sTrAnGe capitalization");
        List<String> tokens = tokenizer.tokenize(scanner);

        assertEquals(List.of("this", "is", "a", "sentence", "with", "strange", "capitalization"), tokens);
    }

    // Wave 3
    @Test
    void testTokenizeSentenceWithPeriod() {
        LowercaseSentenceTokenizer tokenizer = new LowercaseSentenceTokenizer();
        Scanner scanner = new Scanner("Hello world. This is an example.");
        List<String> tokens = tokenizer.tokenize(scanner);

        assertEquals(List.of("hello", "world", ".", "this", "is", "an", "example", "."), tokens);
    }

    // Wave 3
    @Test
    void testTokenizeWithInternalPeriod() {
        LowercaseSentenceTokenizer tokenizer = new LowercaseSentenceTokenizer();
        Scanner scanner = new Scanner("Hello world. This is Dr.Smith's example.");
        List<String> tokens = tokenizer.tokenize(scanner);

        assertEquals(List.of("hello", "world", ".", "this", "is", "dr.smith's", "example", "."), tokens);
    }
    
}
