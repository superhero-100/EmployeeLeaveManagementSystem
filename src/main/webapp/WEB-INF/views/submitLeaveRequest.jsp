<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Submit Leave Request</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="min-h-screen bg-gradient-to-br from-gray-100 to-gray-300 flex flex-col">

<!-- Header -->
<header class="bg-white shadow-md py-4 px-8">
    <h1 class="text-2xl font-bold text-gray-800">Submit Leave Request</h1>
    <p class="text-gray-500">Admin Portal - Submit leave for an employee</p>
</header>

<!-- Main Content -->
<main class="flex-grow flex items-center justify-center py-10">
    <div class="bg-white p-8 rounded-2xl shadow-xl w-full max-w-xl">
        <form method="post" action="${pageContext.request.contextPath}/leaveRequest/submit" class="space-y-6">

            <!-- Employee ID Dropdown -->
            <div>
                <label for="empId" class="block text-sm font-medium text-gray-700 mb-1">Select Employee ID</label>
                <select id="empId" name="empId" required
                        class="w-full border border-gray-300 rounded-lg px-4 py-2 bg-white focus:ring-blue-500 focus:border-blue-500">
                    <option value="">-- Select Employee ID --</option>
                    <c:forEach var="emp" items="${employees}">
                        <option value="${emp.id}">${emp.id} - ${emp.name}</option>
                    </c:forEach>
                </select>
            </div>

            <!-- Start Date -->
            <div>
                <label for="startDate" class="block text-sm font-medium text-gray-700 mb-1">Start Date</label>
                <input type="date" id="startDate" name="startDate" required
                       class="w-full border border-gray-300 rounded-lg px-4 py-2 focus:ring-blue-500 focus:border-blue-500">
            </div>

            <!-- End Date -->
            <div>
                <label for="endDate" class="block text-sm font-medium text-gray-700 mb-1">End Date</label>
                <input type="date" id="endDate" name="endDate" required
                       class="w-full border border-gray-300 rounded-lg px-4 py-2 focus:ring-blue-500 focus:border-blue-500">
            </div>

            <!-- Reason -->
            <div>
                <label for="reason" class="block text-sm font-medium text-gray-700 mb-1">Reason for Leave</label>
                <textarea id="reason" name="reason" rows="4" required
                          class="w-full border border-gray-300 rounded-lg px-4 py-2 focus:ring-blue-500 focus:border-blue-500"
                          placeholder="Enter reason for leave..."></textarea>
            </div>

            <!-- Submit Button -->
            <div>
                <button type="submit"
                        class="w-full bg-indigo-600 text-white py-3 rounded-lg font-semibold hover:bg-indigo-700 transition">
                    Submit Leave Request
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
