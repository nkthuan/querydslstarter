package com.credera.querydsl;

public class UserService {

    private static final ThreadLocal<String> currentUser = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return null;
        }
    };


    public static String getCurrentUser() {
        return currentUser.get();
    }

    /**
     * Sets the current user context associated with this thread. The previous service context, if any, is cleared.
     */
    public static void setCurrentUser(String context) {
        currentUser.set(context);
    }

    public UserService() {

    }
}
