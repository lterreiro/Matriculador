/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nls.formacao.matriculador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Moriel Schottlender
 * @version 1.0
 *
 * A Java class meant to provide easy and consistent validation for
 * user-generated input.
 *
 */
public class UserInput {

    private static Scanner keyboard;

    public UserInput(){
        keyboard = new Scanner(System.in);
    }
    
    public UserInput(Scanner sc){
        keyboard = sc;
    }
    
    /**
     * A method to repeatedly ask the user for input until the input is valid.
     * If condition is used, input is measured against it.
     *
     * @param informationText	The information text to prompt to the user.
     * @return	Returns the final value of the accepted input, as a String.
     */
    public String askInputString(String informationText) {
        Boolean error = false;
        String userInp = "";
        do {
            System.out.print(informationText);
            userInp = keyboard.nextLine();
            if ("".equals(userInp)) {
                System.err.println("Erro: Deve ser introduzido um.");
                error = true;
            } else {
                error = false;
            }
        } while (error == true);
        return userInp;
    }
    
    /**
     * A method to repeatedly ask the user for input until the input is valid.
     * If condition is used, input is measured against it.
     *
     * @param informationText	The information text to prompt to the user.
     * @return	Returns the final value of the accepted input, as an integer.
     */
    public int askInputInt(String informationText) {
        Boolean error = false;
        String userInp = "";
        do {
            System.out.print(informationText);
            userInp = keyboard.nextLine();
            if (!this.isType(userInp, "int")) {
                error = true;
                System.err.println("Erro: Deve ser introduzido um valor numérico inteiro.");
            } else {
                error = false;
            }
        } while (error == true);
        return Integer.parseInt(userInp);
    }

    /**
     * A method to repeatedly ask the user for input until the input is valid.
     * If condition is used, input is measured against it.
     *
     * @param informationText	The information text to prompt to the user.
     * @return	Returns the final value of the accepted input, as a double.
     */
    public double askInputDouble(String informationText) {
        Boolean error = false;
        String userInp = "";
        do {
            System.out.print(informationText);
            userInp = keyboard.nextLine();
            if (!this.isType(userInp, "double")) {
                System.err.println("Erro: Deve ser introduzido um valor numérico decimal.");
                error = true;
            } else {
                error = false;
            }

        } while (error == true);
        return Double.parseDouble(userInp);
    }

    /**
     * A method to repeatedly ask the user for input until the input is valid.
     * If condition is used, input is measured against it.
     *
     * @param informationText	The information text to prompt to the user.
     * @return	Returns the final value of the accepted input, as a float.
     */
    public float askInputFloat(String informationText) {
        Boolean error = false;
        String userInp = "";
        do {
            System.out.print(informationText);
            userInp = keyboard.nextLine();
            // validate:
            if (!this.isType(userInp, "float")) {
                System.err.println("Erro: Deve ser introduzido um valor numérico decimal.");
                error = true;
            } else {
                error = false;
            }

        } while (error == true);
        return Float.parseFloat(userInp);
    }
    
    /**
     * A method to repeatedly ask the user for input until the input is valid.
     * If condition is used, input is measured against it.
     *
     * @param informationText	The information text to prompt to the user.
     * @param format date format.
     * @return	Returns the final value of the accepted input, as a Date.
     */
    public Date askInputDateWithFormat(String informationText, String format) {
        Boolean error = false;
        String userInp = "";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        do {
            System.out.print(informationText);
            userInp = keyboard.nextLine();
            
            try {
                sdf.parse(userInp);
            } catch (ParseException ex) {
                Logger.getLogger(UserInput.class.getName()).log(Level.SEVERE, null, ex);
                error = true;
                System.err.printf("Erro: Deve ser introduzido uma data com o formato '%s'.\n", format);
            }
        } while (error == true);
        Date d = null;
        try {
            d = sdf.parse(userInp);
        } catch (ParseException ex) {
            Logger.getLogger(UserInput.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro a obter data.");
            d = null;
        }
        return d;
    }

    /**
     * Tests if a specific input can be converted to a specific type.
     *
     * @param testStr The input to test. Accepts String, int, double or float.
     * @param type	Which type to test against. Accepts 'int','float' or
     * 'double'.
     * @return Boolean	True if can be transformed to requested type. False
     * otherwise.
     */
    public Boolean isType(String testStr, String type) {
        try {
            if (type.equalsIgnoreCase("float")) {
                Float.parseFloat(testStr);
            } else if (type.equalsIgnoreCase("int")) {
                Integer.parseInt(testStr);
            } else if (type.equalsIgnoreCase("double")) {
                Double.parseDouble(testStr);
            }
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
