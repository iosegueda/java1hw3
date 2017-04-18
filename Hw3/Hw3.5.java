//Iris Osegueda

import javax.swing.*;
import java.text.*;

public class Hw3
{

    public static void main(String[] args)
    {
	    int cusnum, ccount, tusage, kwh;
        double ccharge, tcharge;
        String message, finaltotal;
        DecimalFormat myFormat = new DecimalFormat ("0.00");
        JTextArea area = new JTextArea( 8, 25 );
        final int SENTINEL = -999;

        cusnum = Integer.parseInt(JOptionPane.showInputDialog("Please enter a customer number or -999 to quit. "));

        message = "Customer No.\tUsage in Kwh.\tTotal Charges" +
                "\n-----------------------------------------------" ;

        ccount = 0;
        tusage = 0;
        tcharge = 0;

        while (cusnum != SENTINEL)
        {
            message += "\n" + cusnum;
            ccount++;

            kwh = Integer.parseInt(JOptionPane.showInputDialog("Please enter the customer's usage in KWH. "));
            message += "\t" + kwh;
            tusage += kwh;

            ccharge = findCharge( kwh );
            message += "\t" + myFormat.format( ccharge );
            tcharge += ccharge;

            cusnum = Integer.parseInt(JOptionPane.showInputDialog("Please enter a customer number or -999 to quit. "));

        }

        finaltotal = "\n-----------------------------------------------" + "\n" + ccount + "\t" + tusage + "\t" + myFormat.format( tcharge );


        area.setText ( message + finaltotal ) ;


        JOptionPane.showMessageDialog( null, new JScrollPane ( area ));

        System.exit ( 0 );

    }
    public static double findCharge (int kwh )
    {
        final int T1 = 300;
        final int T2 = 300;
        final int T3 = 400;
        final int T4 = 0;

        final double T1COST = 0.09;
        final double T2COST = 0.08;
        final double T3COST = 0.06;
        final double T4COST = 0.05;

        double ccharge= 0;

        if ( kwh >= T1 )
        {
            kwh -= T1;
            ccharge += T1*T1COST;

            if ( kwh >= T2)
            {
                kwh -= T2;
                ccharge += T2*T2COST;

                if ( kwh >= T3 )
                {
                    kwh -= T3;
                    ccharge += T3*T3COST;

                    if ( kwh > T4 )
                    {
                        ccharge += kwh*T4COST;
                    }
                }
                else
                {
                    ccharge += kwh*T3COST;
                }
            }
            else
            {
                ccharge += kwh*T2COST;
            }

        }
        else
        {
            ccharge = kwh*T1COST;
        }

        return ccharge;
    }
}
