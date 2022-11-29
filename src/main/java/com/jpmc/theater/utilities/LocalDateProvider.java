package com.jpmc.theater.utilities;

import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class LocalDateProvider {

    private LocalDateProvider() {};

    /**
     * @return make sure to return singleton instance
     */
    private static class LocalDateProviderSingleton {
        private static final LocalDateProvider INSTANCE = new LocalDateProvider();
    }

    public static LocalDateProvider getSingleton() {
        return LocalDateProviderSingleton.INSTANCE;
    }

    //Zone Id should be marked based on the timezone.
    //Assuming UTC here  
    public LocalDate currentDate() {
        return LocalDate.now(ZoneId.of("UTC"));
    }
}
