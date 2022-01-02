package com.autosell.util;

public class StringUtil {
	
	private static StringUtil INSTANCE = null;
    public static StringUtil getInstance() {
        if (null==INSTANCE) {
            INSTANCE = new StringUtil();
        }
        return INSTANCE;
    }
	
	public Boolean containsIgnoreCase(String str1, String str2) {
		return str1.toLowerCase().contains(str2.toLowerCase());
	}

    private static int calculatePasswordStrength(String password){
        int passwordScore = 0;

        if(password.length() < 6) {
            return 0;
        } else if( password.length() >= 8 ) {
            passwordScore += 2;
        } else {
            passwordScore += 1;
        }

        /*
         * if password contains 2 digits, add 2 to score.
         * if contains 1 digit add 1 to score
         */
        if(password.matches("(?=.*[0-9].*[0-9]).*")) {
            passwordScore += 2;
        }
        else if ( password.matches("(?=.*[0-9]).*")) {
            passwordScore += 1;
        }

        //if password contains 1 lower case letter, add 2 to score
        if(password.matches("(?=.*[a-z]).*")) {
            passwordScore += 2;
        }

        /*
         * if password contains 2 upper case letters, add 2 to score.
         * if contains only 1 then add 1 to score.
         */
        if(password.matches("(?=.*[A-Z].*[A-Z]).*")) {
            passwordScore += 2;
        }
        else if( password.matches("(?=.*[A-Z]).*")) {
            passwordScore += 1;
        }

        /*
         * if password contains 2 special characters, add 2 to score.
         * if contains only 1 special character then add 1 to score.
         */
        if(password.matches("(?=.*[~!@#$%^&*()_-].*[~!@#$%^&*()_-]).*")) {
            passwordScore += 2;
        }
        else if( password.matches("(?=.*[~!@#$%^&*()_-]).*")) {
            passwordScore += 1;
        }

        return passwordScore;

    }

}
