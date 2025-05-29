<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Leave Requests</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="min-h-screen bg-gray-100">

<!-- Header -->
<header class="bg-white shadow p-6 mb-6">
    <h1 class="text-2xl font-bold text-gray-800">Leave Request Dashboard</h1>
    <p class="text-gray-600">Review and manage all submitted leave requests.</p>
</header>

<!-- Main Table -->
<main class="container mx-auto px-6">
    <div class="bg-white p-6 rounded-xl shadow overflow-x-auto">
        <table class="min-w-full text-sm text-left text-gray-700">
            <thead>
            <tr class="bg-gray-200 text-gray-700">
                <th class="px-4 py-2">Emp ID</th>
                <th class="px-4 py-2">Name</th>
                <th class="px-4 py-2">Email</th>
                <th class="px-4 py-2">Designation</th>
                <th class="px-4 py-2">Leave Balance</th>
                <th class="px-4 py-2">Start Date</th>
                <th class="px-4 py-2">End Date</th>
                <th class="px-4 py-2">Reason</th>
                <th class="px-4 py-2">Status</th>
                <th class="px-4 py-2 text-center">Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="request" items="${leaveRequests}">
                <tr class="border-t hover:bg-gray-100">
                    <td class="px-4 py-2">${request.employeeId}</td>
                    <td class="px-4 py-2">${request.name}</td>
                    <td class="px-4 py-2">${request.email}</td>
                    <td class="px-4 py-2">${request.designation}</td>
                    <td class="px-4 py-2">${request.leaveBalance}</td>
                    <td class="px-4 py-2">${request.startDate}</td>
                    <td class="px-4 py-2">${request.endDate}</td>
                    <td class="px-4 py-2">${request.reason}</td>
                    <td class="px-4 py-2 font-bold">${request.status}</td>
                    <td class="px-4 py-2 flex gap-2 justify-center">
                        <a href="${pageContext.request.contextPath}/leaveRequest/approve/${request.id}" class="bg-green-500 text-white px-3 py-1 rounded hover:bg-green-600">Approve</a>
                        <a href="${pageContext.request.contextPath}/leaveRequest/reject/${request.id}" class="bg-red-500 text-white px-3 py-1 rounded hover:bg-red-600">Reject</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</main>

<!-- Footer -->
<footer class="text-center py-4 text-sm text-gray-500">
    &copy; 2025 Employee Leave Management System. Admin Portal.
</footer>

</body>
</html>
