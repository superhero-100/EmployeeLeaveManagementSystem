<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Error</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-red-50 min-h-screen flex items-center justify-center">

<div class="bg-white p-10 rounded-2xl shadow-lg text-center max-w-lg">
    <h1 class="text-3xl font-bold text-red-600 mb-4">Error</h1>
    <p class="text-gray-700 text-lg">${error}</p>
    <a href="${pageContext.request.contextPath}/" class="mt-6 inline-block px-6 py-2 bg-red-600 text-white rounded-lg hover:bg-red-700 transition">
        Go to Home
    </a>
</div>

</body>
</html>
