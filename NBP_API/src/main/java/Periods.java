import java.time.LocalDate;

public enum Periods {
    ONE_WEEK {
        public String toString(){
            LocalDate today = LocalDate.now().minusDays(7);
            return today.toString();
        }
    },
    TWO_WEEKS {
        public String toString(){
            LocalDate today = LocalDate.now().minusWeeks(2);
            return today.toString();
        }
    },
    ONE_MONTH {
        public String toString(){
            LocalDate today = LocalDate.now().minusMonths(1);
            return today.toString();
        }
    },
    THREE_MONTHS {
        public String toString(){
            LocalDate today = LocalDate.now().minusMonths(3);
            return today.toString();
        }
    },
    SIX_MONTHS {
        public String toString(){
            LocalDate today = LocalDate.now().minusMonths(6);
            return today.toString();
        }
    },
    ONE_YEAR {
        public String toString(){
            LocalDate today = LocalDate.now().minusYears(1);
            return today.toString();
        }
    },
    LAST_QUARTER {
        public String toString(){
            LocalDate today = LocalDate.now();
            if(today.getMonth().getValue() <= 3){
                return LocalDate.of(today.getYear()-1, 10, 1).toString();
            }
            if (today.getMonth().getValue() <= 6){
                return LocalDate.of(today.getYear(), 1, 1).toString();
            }
            if (today.getMonth().getValue() <= 9){
                return LocalDate.of(today.getYear(), 4, 1).toString();
            } else {
                return LocalDate.of(today.getYear(), 7, 1).toString();
            }
        }
    },
    PREV_MONTH {
        public String toString(){
            LocalDate today = LocalDate.now();
            if(today.getMonth().getValue() == 1){
                return LocalDate.of(today.getYear()-1, 12, 1).toString();
            } else {
                return LocalDate.of(today.getYear(), today.getMonth().minus(1), 1).toString();
            }
        }
    };
}
