package cookirun;

import java.awt.Image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jelly {
	Image image;
	int x;
	int y;
	int width;
	int height;
	int alpha; // 255 
	int score;
}
