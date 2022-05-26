package parkyujin.service;

import com.nhnacademy.parkyujin.repository.WaterBill;
import com.nhnacademy.parkyujin.service.ResultReportService;
import com.nhnacademy.parkyujin.service.WaterBillService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class WaterBillServiceTest {

    private WaterBillService basicWaterBillService;

    @Test
    @DisplayName("사용량에 따른 가격을 잘 계산하는지")
    void report() {
        basicWaterBillService.calculateBill(1000);
    }

}
