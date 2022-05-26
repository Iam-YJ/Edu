package parkyujin.repository;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.nhnacademy.parkyujin.main.BootStrap;
import com.nhnacademy.parkyujin.repository.DataParser;
import java.io.File;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class DataParserTest {
    private DataParser csvDataParser;
    private DataParser jsonDataParser;

    private final File csvFile = new File(
        BootStrap.class.getClassLoader().getResource("data/Tariff_20220331.csv").getFile());
    private final File jsonFile = new File(BootStrap.class.getClassLoader().getResource("data/Tariff_20220331.json").getFile());

    @Test
    @DisplayName("csv 파일을 잘 파싱하는지")
    void csvLoad() {
        assertThrows(IllegalStateException.class, () -> {
            csvDataParser.parse(csvFile);
        });
    }

    @Test
    @DisplayName("json 파일을 잘 파싱하는지")
    void jsonLoad() {
        assertThrows(IllegalStateException.class, () -> {
            jsonDataParser.parse(jsonFile);
        });
    }

}
