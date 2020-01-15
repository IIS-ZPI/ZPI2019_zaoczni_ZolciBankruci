import java.time.LocalDate;

public enum Periods {
    ONE_WEEK,
    TWO_WEEKS,
    ONE_MONTH,
    THREE_MONTHS,
    SIX_MONTHS,
    ONE_YEAR,
    LAST_QUATER {
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
