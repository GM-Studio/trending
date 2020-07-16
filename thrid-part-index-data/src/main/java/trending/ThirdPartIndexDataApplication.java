package trending;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Squirrel-Chen
 */
@SpringBootApplication
public class ThirdPartIndexDataApplication {

    private static final Logger logger= LoggerFactory.getLogger(ThirdPartIndexDataApplication.class);

    public static void main(String[] args) {
        logger.info("ThirdPartIndexDataApplication 正在启动中················");
        SpringApplication.run(ThirdPartIndexDataApplication.class);
        logger.info("ThirdParIndexDataApplication 启动完毕，正在运行中·········");
    }
}
