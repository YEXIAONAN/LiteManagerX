package com.xn.lmx.setting.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class DatasourceCheckProperties {

    private String url;
    private String username;
    private String password;

    public boolean isValid() {
        return url != null && !url.isBlank()
                && username != null && !username.isBlank()
                && password != null && !password.isBlank();
    }

    // Getter / Setter
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
