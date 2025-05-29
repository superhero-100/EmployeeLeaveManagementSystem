<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="min-h-screen bg-gray-100 flex flex-col">

<!-- Header -->
<header class="bg-white shadow-md py-4 px-8">
    <h1 class="text-3xl font-bold text-gray-800">All Employees</h1>
    <p class="text-gray-500">Admin portal - List of registered employees and leave balances</p>
</header>

<!-- Content -->
<main class="flex-grow py-8 px-6">
    <div class="overflow-x-auto bg-white rounded-xl shadow-lg p-6">
        <table class="min-w-full divide-y divide-gray-200">
            <thead class="bg-gray-100">
            <tr>
                <th class="px-4 py-3 text-left text-sm font-semibold text-gray-700">ID</th>
                <th class="px-4 py-3 text-left text-sm font-semibold text-gray-700">Name</th>
                <th class="px-4 py-3 text-left text-sm font-semibold text-gray-700">Email</th>
                <th class="px-4 py-3 text-left text-sm font-semibold text-gray-700">Designation</th>
                <th class="px-4 py-3 text-left text-sm font-semibold text-gray-700">Leave Balance</th>
                <th class="px-4 py-3 text-left text-sm font-semibold text-gray-700">Action</th>
            </tr>
            </thead>
            <tbody class="bg-white divide-y divide-gray-200">
            <c:forEach var="emp" items="${employees}">
                <tr class="hover:bg-gray-50">
                    <td class="px-4 py-3 text-sm text-gray-800">${emp.id}</td>
                    <td class="px-4 py-3 text-sm text-gray-800">${emp.name}</td>
                    <td class="px-4 py-3 text-sm text-gray-800">${emp.email}</td>
                    <td class="px-4 py-3 text-sm text-gray-800">${emp.designation}</td>
                    <td class="px-4 py-3 text-sm text-gray-800">${emp.leaveBalance}</td>
                    <td class="px-4 py-3 text-sm text-gray-800 gap-2">
                        <a href="${pageContext.request.contextPath}/leaveBalance/add/${emp.id}"
                           class="inline-block bg-blue-600 text-white px-4 py-2 rounded-lg text-sm font-medium hover:bg-blue-700 transition">
                            Add Leave Balance
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <c:if test="${empty employees}">
            <div class="text-center text-gray-500 mt-6">
                No employee records available.
            </div>
        </c:if>
    </div>
</main>

<!-- Footer -->
<footer class="bg-white py-4 px-8 shadow-inner text-center text-sm text-gray-500">
    &copy; 2025 Employee Leave Management System. Admin Portal.
</footer>

</body>
</html>
