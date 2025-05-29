<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Leave Balance</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="min-h-screen bg-gradient-to-br from-gray-100 to-gray-300 flex flex-col">

<!-- Header -->
<header class="bg-white shadow-md py-4 px-8">
    <h1 class="text-2xl font-bold text-gray-800">Add Leave Balance</h1>
    <p class="text-gray-500">Admin Portal - Add leave to employee ID: <strong>${empId}</strong></p>
</header>

<!-- Main Content -->
<main class="flex-grow flex items-center justify-center py-10">
    <div class="bg-white p-8 rounded-2xl shadow-xl w-full max-w-md">
        <form method="post" action="${pageContext.request.contextPath}/leaveBalance/add/${empId}" class="space-y-6">
            <div>
                <label for="leaveBalence" class="block text-sm font-medium text-gray-700 mb-1">Leave to Add</label>
                <input type="number" id="leaveBalence" name="leaveBalence" required min="1"
                       class="w-full border border-gray-300 rounded-lg px-4 py-2 focus:ring-blue-500 focus:border-blue-500">
            </div>

            <div>
                <button type="submit"
                        class="w-full bg-green-600 text-white py-3 rounded-lg font-semibold hover:bg-green-700 transition">
                    Update Leave Balance
                </button>
            </div>
        </form>
    </div>
</main>

<!-- Footer -->
<footer class="bg-white py-4 px-8 shadow-inner text-center text-sm text-gray-500">
    &copy; 2025 Employee Leave Management System. Admin Portal.
</footer>

</body>
</html>
