package parkyujin.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

import com.nhnacademy.parkyujin.main.BootStrap;
import com.nhnacademy.parkyujin.repository.BasicBillRepository;
import com.nhnacademy.parkyujin.repository.BillRepository;
import com.nhnacademy.parkyujin.repository.DataParser;
import com.nhnacademy.parkyujin.repository.RawWaterBill;
import com.nhnacademy.parkyujin.repository.WaterBill;
import java.io.File;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class BillRespositoryTest{
    private final File csvFile = new File(BootStrap.class.getClassLoader().getResource("data/Tariff_20220331.csv").getFile());
    private final File jsonFile = new File(BootStrap.class.getClassLoader().getResource("data/Tariff_20220331.json").getFile());

    private BillRepository basicBillRepository;

    private DataParser csvDataParser;
    private DataParser jsonDataParser;
    private List<RawWaterBill> rawWaterBillList;
    private List<WaterBill> waterBillList;

    @BeforeAll
    void setUp() {
        basicBillRepository = new BasicBillRepository(csvDataParser, jsonDataParser, rawWaterBillList, waterBillList);
        basicBillRepository.csvLoad(csvFile);
//        basicBillRepository.jsonLoad(jsonFile);
    }

    @Test
    @DisplayName("csv 파일을 잘 가져오는지")
    void csvLoad() {
        assertThrows(IllegalStateException.class, () -> {
            basicBillRepository.csvLoad(csvFile);
        });
    }

    @Test
    @DisplayName("json 파일을 잘 가져오는지")
    void jsonLoad() {
//        assertThrows(IllegalStateException.class, () -> {
//            basicBillRepository.jsonLoad(jsonFile);
//        });
    }

    @Test
    @DisplayName("사용량에 따른 표금을 잘 찾는지")
    void findBillByUsage() {
        Collection<WaterBill> waterBills = basicBillRepository.findBillByUsage(1000);
        assertThat(waterBills).isNotNull();
        assertThat(waterBills).isNotEmpty();
    }
}
