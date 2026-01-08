package com.xn.lmx.setting.startup;

import com.xn.lmx.setting.config.DatasourceCheckProperties;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupConfigChecker implements ApplicationRunner {

    private final DatasourceCheckProperties datasource;

    public StartupConfigChecker(DatasourceCheckProperties datasource) {
        this.datasource = datasource;
    }

    @Override
    public void run(ApplicationArguments args) {
        if (!datasource.isValid()) {
            System.err.println("====================================");
            System.err.println("❌ 数据库配置未完成");
            System.err.println("👉 请填写 config/application.yml");
            System.err.println("👉 示例文件：config/application-example.yml");
            System.err.println("====================================");
            System.exit(1);
        }
    }
}
