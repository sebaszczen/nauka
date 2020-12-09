package nauka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Sum {

     int x;
     int y;

    public int sum() {
        return x + y;
    }

    public Sum(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
