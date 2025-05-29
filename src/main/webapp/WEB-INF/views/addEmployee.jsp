<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add New Employee</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="min-h-screen bg-gradient-to-br from-gray-100 to-gray-300 flex flex-col">

<!-- Header -->
<header class="bg-white shadow-md py-4 px-8">
    <h1 class="text-2xl font-bold text-gray-800">Add Employee</h1>
    <p class="text-gray-500">Admin portal - Add a new employee record</p>
</header>

<!-- Main Form -->
<main class="flex-grow flex justify-center items-center py-10">
    <div class="bg-white p-10 rounded-2xl shadow-lg w-full max-w-xl">
        <form:form modelAttribute="employee" action="${pageContext.request.contextPath}/employee/add" method="post" class="space-y-6">

            <!-- Name -->
            <div>
                <label for="name" class="block text-sm font-medium text-gray-700 mb-1">Name</label>
                <form:input path="name" cssClass="w-full border border-gray-300 rounded-lg px-4 py-2 focus:ring-blue-500 focus:border-blue-500"/>
                <form:errors path="name" cssClass="text-red-600 text-sm mt-1"/>
            </div>

            <!-- Email -->
            <div>
                <label for="email" class="block text-sm font-medium text-gray-700 mb-1">Email</label>
                <form:input path="email" type="email" cssClass="w-full border border-gray-300 rounded-lg px-4 py-2 focus:ring-blue-500 focus:border-blue-500"/>
                <form:errors path="email" cssClass="text-red-600 text-sm mt-1"/>
            </div>

            <!-- Designation -->
            <div>
                <label for="designation" class="block text-sm font-medium text-gray-700 mb-1">Designation</label>
                <form:input path="designation" cssClass="w-full border border-gray-300 rounded-lg px-4 py-2 focus:ring-blue-500 focus:border-blue-500"/>
                <form:errors path="designation" cssClass="text-red-600 text-sm mt-1"/>
            </div>

            <!-- Leave Balance -->
            <div>
                <label for="leaveBalance" class="block text-sm font-medium text-gray-700 mb-1">Initial Leave Balance</label>
                <form:input path="leaveBalance" type="number" cssClass="w-full border border-gray-300 rounded-lg px-4 py-2 focus:ring-blue-500 focus:border-blue-500"/>
                <form:errors path="leaveBalance" cssClass="text-red-600 text-sm mt-1"/>
            </div>

            <!-- Submit -->
            <div class="pt-4">
                <button type="submit" class="w-full bg-blue-600 text-white py-3 rounded-lg font-semibold hover:bg-blue-700 transition">
                    Add Employee
                </button>
            </div>
        </form:form>
    </div>
</main>

<!-- Footer -->
<footer class="bg-white py-4 px-8 shadow-inner text-center text-sm text-gray-500">
    &copy; 2025 Employee Leave Management System. Admin Portal.
</footer>

</body>
</html>