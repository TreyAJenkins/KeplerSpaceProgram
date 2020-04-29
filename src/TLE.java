// https://en.wikipedia.org/wiki/Two-line_element_set

public class TLE {

    private String title;
    private String catnum;
    private String classification;
    private String designator;
    private int epochYear;
    private double epochDay;
    private double firstMean; // First Derivative of Mean Motion (Ballistic Coefficient)
    private double secondMean; // Second Derivative of Mean Motion
    private double dragTerm; // aka Radiation Pressure Coefficient or BSTAR
    private double inclination;
    private double ascension; // Right Ascension of the Ascending Node
    private double eccentricity;
    private double perigee; // Argument of Perigee
    private double anomaly; // Mean Anomaly
    private double meanMotion; // Revolutions per day
    private double revNum; // Revolution number at epoch

    @Override
    public String toString() {
        String str = "Title: " + title + "\n" +
                "Catnum: " + catnum + "\n"+
                "Classification: " + classification + "\n"+
                "Designator: " + designator + "\n" +
                "Epoch: " + epochYear + " - " + epochDay + "\n" +
                "Derivatives: " + firstMean + ", " + secondMean + "\n" +
                "Drag term: " + dragTerm + "\n" +
                "Inclination: " + inclination + "\n" +
                "Ascension: " + ascension + "\n" +
                "Eccentricity: " + eccentricity + "\n" +
                "Perigee: " + perigee + "\n" +
                "Anomaly: " + anomaly + "\n" +
                "Mean Motion: " + meanMotion + "\n" +
                "Rev num: " + revNum + "\n";
        return str;
    }

    private void parseString(String[] str) {
        title = str[0].trim();
        catnum = str[1].substring(2,7).trim();
        classification = str[1].substring(7,8);
        designator = str[1].substring(9, 17).trim();
        epochYear = Integer.parseInt(str[1].substring(18, 20));
        epochDay = Double.parseDouble(str[1].substring(20, 32));
        firstMean = Double.parseDouble(str[1].substring(33, 43));

        String secondMeanStr = str[1].substring(44,50).trim();
        if (secondMeanStr.contains("-"))
            secondMeanStr = "-0." + secondMeanStr.substring(1);
        else
            secondMeanStr = "0." + secondMeanStr;
        secondMeanStr += "E" + str[1].substring(50,52);
        secondMean = Double.parseDouble(secondMeanStr);

        String dragTermStr = str[1].substring(53,59).trim();
        if (dragTermStr.contains("-"))
            dragTermStr = "-0." + dragTermStr.substring(1);
        else
            dragTermStr = "0." + dragTermStr;
        dragTermStr += "E" + str[1].substring(59,61);
        dragTerm = Double.parseDouble(dragTermStr);


        inclination = Double.parseDouble(str[2].substring(8,16));
        ascension = Double.parseDouble(str[2].substring(17,25));
        eccentricity = Double.parseDouble("0." + str[2].substring(26,33).trim());
        perigee = Double.parseDouble(str[2].substring(34,42));
        anomaly = Double.parseDouble(str[2].substring(43,51));
        meanMotion = Double.parseDouble(str[2].substring(52, 63));
        revNum = Double.parseDouble(str[2].substring(63,68));
    }

    public TLE(String string) {
        String[] str = string.split("\n");
        parseString(str);
    }

    public String getTitle() {
        return title;
    }

    public String getCatnum() {
        return catnum;
    }

    public String getClassification() {
        return classification;
    }

    public String getDesignator() {
        return designator;
    }

    public int getEpochYear() {
        return epochYear;
    }

    public double getEpochDay() {
        return epochDay;
    }

    public double getFirstMean() {
        return firstMean;
    }

    public double getSecondMean() {
        return secondMean;
    }

    public double getDragTerm() {
        return dragTerm;
    }

    public double getInclination() {
        return inclination;
    }

    public double getAscension() {
        return ascension;
    }

    public double getEccentricity() {
        return eccentricity;
    }

    public double getPerigee() {
        return perigee;
    }

    public double getAnomaly() {
        return anomaly;
    }

    public double getMeanMotion() {
        return meanMotion;
    }

    public double getRevNum() {
        return revNum;
    }
}
