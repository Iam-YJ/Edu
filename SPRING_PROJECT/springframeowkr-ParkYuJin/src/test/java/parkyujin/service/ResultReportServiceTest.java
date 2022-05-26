package parkyujin.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.parkyujin.repository.WaterBill;
import com.nhnacademy.parkyujin.service.ResultReportService;
import java.util.Collection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class ResultReportServiceTest {

    private ResultReportService basicResultReportService;
    @Test
    @DisplayName("사용량에 따른 가격을 잘 출력하는지")
    void report() {
        basicResultReportService.report(1000);
    }

}
