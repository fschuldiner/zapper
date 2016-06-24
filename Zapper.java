import java.util.Date;
import java.util.Random;

public class Zapper {
    public static void main(String[] args) throws Exception {
        Process p1 = Runtime.getRuntime().exec(new String[] {"bash", "-c", "echo 17 > /sys/class/gpio/export"});
        p1.waitFor();
        Process p2 = Runtime.getRuntime().exec(new String[] {"bash", "-c", "echo out > /sys/class/gpio/gpio17/direction"});
        p2.waitFor();

        Process p3 = Runtime.getRuntime().exec(new String[] {"bash", "-c", "echo 5 > /sys/class/gpio/export"});
        p3.waitFor();
        Process p4 = Runtime.getRuntime().exec(new String[] {"bash", "-c", "echo out > /sys/class/gpio/gpio5/direction"});
        p4.waitFor();
        boolean on = false;
        Random random = new Random();
	String[] on5 = new String[] {"bash", "-c", "echo 1 > /sys/class/gpio/gpio5/value"};
	String[] off17 = new String[] {"bash", "-c", "echo 0 > /sys/class/gpio/gpio17/value"};
	String[] off5 = new String[] {"bash", "-c", "echo 0 > /sys/class/gpio/gpio5/value"};
	String[] on17 = new String[] {"bash", "-c", "echo 1 > /sys/class/gpio/gpio17/value"};

        Long inicio = (new Date()).getTime();
	Long fin = (60*10*1000)+(30*1000)+inicio;
        while(fin-((new Date()).getTime()) > 0 ) {
	    Process p6 = Runtime.getRuntime().exec(on5);
            Process p5 = Runtime.getRuntime().exec(off17);
            Thread.sleep(20L);
	    Process p7 = Runtime.getRuntime().exec(off5);
            Process p8 = Runtime.getRuntime().exec(on17);
	    Thread.sleep(20L);
	}
    }
}
