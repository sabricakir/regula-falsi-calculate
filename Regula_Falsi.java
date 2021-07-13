public class Regula_Falsi {

    private double calculateFunction(double x) {
        //write here your equation for example down there equation is f(x) = e^x - 3x;
        return Math.pow(Math.E, x) - 3.0 * x;
    }

    public void calculateRegulaFalsi() {
        //xl first value 
        //xr last value
        DecimalFormat frm = new DecimalFormat("#.######");
        int i = 0;
        double xm, xl = 0, xr = 1;
        double ym, yr, yl;
        double td = 0.001;
        while (true) {
            yl = calculateFunction(xl);
            yr = calculateFunction(xr);
            if ((yl * yr) > 0) {
                System.out.println(("Not a Value in Specified Range !"));
                break;
            }
            xm = (xl * yr - xr * yl) / (yr - yl);
            ym = calculateFunction(xm);
            if (Math.abs(ym) <= td) {
                i++;
                System.out.println(i + ".iteration " + "xl : " + frm.format(xl) + "\t" + "xr : " + frm.format(xr) + "\t"
                        + "xm : " + frm.format(xm) + "\t" + "yl : " + frm.format(yl) + "\t" + "yr : " + frm.format(yr) + "\t"
                        + "ym : " + frm.format(ym) + "\t\n");
                System.out.println("Searching Value : " + frm.format(xm));
                break;
            }
            i++;
            System.out.println(i + ".iteration " + "xl : " + frm.format(xl) + "\t" + "xr : " + frm.format(xr) + "\t"
                    + "xm : " + frm.format(xm) + "\t" + "yl : " + frm.format(yl) + "\t" + "yr : " + frm.format(yr) + "\t"
                    + "ym : " + frm.format(ym) + "\t\n");
            if ((yl * ym) < 0) {
                xr = xm;
                yr = ym;
            }
            if ((yl * ym) > 0) {
                xl = xm;
                yl = ym;
            }

        }
    }
}
