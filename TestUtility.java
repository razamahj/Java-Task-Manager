import static org.junit.Assert.*;
import org.junit.After; 
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.*;

/**
 * DO NOT EDIT THIS CLASS.
 * 
 * @author Dr A J Beaumont 
 * @version November 2015
 */
public class TestUtility
{
    public static void checkField(String className, String name, Class<?> type) {
        try {
            Class<?> cls = Class.forName(className);
            Field nameField = cls.getDeclaredField(name);
            int foundMods = nameField.getModifiers();
            if (!Modifier.isPrivate(foundMods)) {
                fail("The field called " + name + " should be declared to be private");
            }

            assertEquals("The field called " + name + " is not declared to be type "
                + type,
                type, nameField.getType());
        } catch (ClassNotFoundException e) {
            fail("There should be a class in your project called " + className +
                ". However I cannot find it.  Did you spell its name correctly?");
        } catch (NoSuchFieldException e) {
            fail("There should be a private field called " + name +
                ".  If you think you put it there, check your spelling of it");
        }
    }

    public static void checkConstructor(String className, Class<?>[] paramList) {

        try {
            Class<?> cls = Class.forName(className); 
            Constructor[] allConstructors = cls.getDeclaredConstructors();
            assertEquals("The class called " + className + "should have 1 constructor",
                1, allConstructors.length);

            Type[] pType = allConstructors[0].getGenericParameterTypes();
            int numParam = pType.length;
            assertEquals("There should be " + paramList.length + 
                " parameters in your constructor but you have " + numParam,
                paramList.length, numParam);
            for (int i = 0; i < pType.length; i++) {
                Type type = pType[i];
                assertEquals("Checking the type of parameter " + i +
                    " which should be declared as " + paramList[i],
                    paramList[i], type);

            }
        } catch (ClassNotFoundException e) {
            fail("There should be a class in your project called " + className +
                ". However I cannot find it.  Did you spell its name correctly?");
        }
    }

    public static void checkMethod(String className, String methodName, Class<?>[] argTypes, Class<?> returnType) {
        String argDescription = "";
        if (argTypes == null) {
            argDescription = "no arguments";
        }
        try {
            Class<?> cls = Class.forName(className); 
            try {
                Method m = cls.getMethod(methodName, argTypes);
                assertTrue("Method called " + methodName + " should have " + argDescription,
                    m != (null));
                Type retType = m.getGenericReturnType();
                assertEquals("Method called " + methodName + " should return " + returnType,
                    returnType, retType);
            } catch (NoSuchMethodException nsm) {
                fail("There should be a method in the " + className + " class called " + methodName +
                    " with " + argDescription + ". However I cannot find it.  "+
                    "Did you spell its name correctly or get the number of arguments wrong?");
            }

        } catch (ClassNotFoundException e) {
            fail("There should be a class in your project called " + className +
                ". However I cannot find it.  Did you spell its name correctly?");
        }
    }

}
