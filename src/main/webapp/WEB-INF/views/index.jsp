<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin | Employee Leave Management System</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="min-h-screen bg-gradient-to-r from-blue-100 to-purple-100 flex flex-col justify-between">

<!-- Header -->
<header class="bg-white shadow-md py-4 px-8 flex items-center justify-between">
    <h1 class="text-2xl font-bold text-gray-800">Employee Leave Management - Admin Panel</h1>
    <nav>
        <a href="index.jsp" class="text-blue-600 hover:text-blue-800 font-medium">Home</a>
    </nav>
</header>

<!-- Main Dashboard -->
<main class="flex-grow flex items-center justify-center py-12">
    <div class="bg-white p-10 rounded-2xl shadow-xl w-full max-w-4xl">
        <h2 class="text-3xl font-bold text-center text-gray-800 mb-10">Welcome, Admin</h2>
        <p class="text-center text-gray-500 mb-6">Use the options below to manage employees, leave balances, and requests.</p>

        <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
            <!-- Add Employee -->
            <a href="${pageContext.request.contextPath}/employee/add" class="block bg-blue-600 text-white text-center py-4 rounded-xl hover:bg-blue-700 transition">
                Add New Employee
            </a>

            <!-- View All Employees & Assign Leave -->
            <a href="${pageContext.request.contextPath}/employee/list" class="block bg-green-600 text-white text-center py-4 rounded-xl hover:bg-green-700 transition">
                View Employees & Assign Leave Balance
            </a>

            <!-- Submit Leave Request (Admin Assistance) -->
            <a href="${pageContext.request.contextPath}/leaveRequest/submit" class="block bg-indigo-600 text-white text-center py-4 rounded-xl hover:bg-indigo-700 transition">
                Submit Leave Request on Behalf
            </a>

            <!-- Manage Leave Requests -->
            <a href="${pageContext.request.contextPath}/leaveRequest/list" class="block bg-red-600 text-white text-center py-4 rounded-xl hover:bg-red-700 transition">
                View / Approve / Reject Leave Requests
            </a>

        </div>
    </div>
</main>

<!-- Footer -->
<footer class="bg-white py-4 px-8 shadow-inner text-center text-sm text-gray-500">
    &copy; 2025 Employee Leave Management System. Admin Portal.
</footer>

</body>
</html>
