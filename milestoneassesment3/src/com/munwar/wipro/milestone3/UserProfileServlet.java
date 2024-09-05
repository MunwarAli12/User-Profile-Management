package com.munwar.wipro.milestone3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userProfile")
public class UserProfileServlet extends HttpServlet {
    private UserProfileService userProfileService = new UserProfileService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "create":
                handleCreate(request, response);
                break;
            case "update":
                handleUpdate(request, response);
                break;
            case "delete":
                handleDelete(request, response);
                break;
            case "get":
                handleGet(request, response);
                break;
        }
    }

    private void handleCreate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userId = request.getParameter("userId");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        UserProfile userProfile = new UserProfile(userId, firstName, lastName, email);
        boolean success = userProfileService.createUserProfile(userId, userProfile);

        response.getWriter().write(success ? "Profile created successfully" : "User ID already exists");
    }

    private void handleUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userId = request.getParameter("userId");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        UserProfile updatedProfile = new UserProfile(userId, firstName, lastName, email);
        boolean success = userProfileService.updateUserProfile(userId, updatedProfile);

        response.getWriter().write(success ? "Profile updated successfully" : "User ID does not exist");
    }

    private void handleDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userId = request.getParameter("userId");
        boolean success = userProfileService.deleteUserProfile(userId);

        response.getWriter().write(success ? "Profile deleted successfully" : "User ID does not exist");
    }

    private void handleGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userId = request.getParameter("userId");
        UserProfile userProfile = userProfileService.getUserProfile(userId);

        if (userProfile != null) {
            response.getWriter().write("User Profile: " + userProfile.getFirstName() + " " + userProfile.getLastName() + ", Email: " + userProfile.getEmail());
        } else {
            response.getWriter().write("User ID does not exist");
        }
    }
}
