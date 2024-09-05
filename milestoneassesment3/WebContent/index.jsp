<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Profile Management</title>
</head>
<body>
    <h1>User Profile Management Service</h1>
    <form action="userProfile" method="post">
        <input type="hidden" name="action" value="create">
        <label>User ID: <input type="text" name="userId"></label><br>
        <label>First Name: <input type="text" name="firstName"></label><br>
        <label>Last Name: <input type="text" name="lastName"></label><br>
        <label>Email: <input type="text" name="email"></label><br>
        <input type="submit" value="Create Profile">
    </form>
    <br>
    <form action="userProfile" method="post">
        <input type="hidden" name="action" value="get">
        <label>User ID: <input type="text" name="userId"></label>
        <input type="submit" value="Get Profile">
    </form>
    <br>
    <form action="userProfile" method="post">
        <input type="hidden" name="action" value="update">
        <label>User ID: <input type="text" name="userId"></label><br>
        <label>First Name: <input type="text" name="firstName"></label><br>
        <label>Last Name: <input type="text" name="lastName"></label><br>
        <label>Email: <input type="text" name="email"></label><br>
        <input type="submit" value="Update Profile">
    </form>
    <br>
    <form action="userProfile" method="post">
        <input type="hidden" name="action" value="delete">
        <label>User ID: <input type="text" name="userId"></label>
        <input type="submit" value="Delete Profile">
    </form>
</body>
</html>
