<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
    <title>My List</title>
    <style>
      table {
        border-collapse: collapse;
        margin: 20px auto;
      }
      th, td {
        border: 1px solid black;
        padding: 5px 10px;
      }
      th {
        background-color: #eee;
      }
      td button {
        background-color: #f44336;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
      }
      td button:hover {
        background-color: #d32f2f;
      }
    </style>
  </head>
  <body>
    <h1>My List</h1>
    <table>
      <thead>
        <tr>
          <th>Name</th>
          <th>Description</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <%-- Sample data --%>
        <%
          List<Item> items = new ArrayList<>();
          items.add(new Item("Item 1", "Description for Item 1"));
          items.add(new Item("Item 2", "Description for Item 2"));
          items.add(new Item("Item 3", "Description for Item 3"));
          items.add(new Item("Item 4", "Description for Item 4"));
          items.add(new Item("Item 5", "Description for Item 5"));
          for (Item item : items) {
            out.print("<tr>");
            out.print("<td>" + item.getName() + "</td>");
            out.print("<td>" + item.getDescription() + "</td>");
            out.print("<td><button onclick=\"deleteItem('" + item.getName() + "')\">Delete</button></td>");
            out.print("</tr>");
          }
        %>
      </tbody>
    </table>
    <script>
      function deleteItem(name) {
        // Send AJAX request to delete item from server
        console.log("Deleting item " + name);
      }
    </script>
  </body>
</html>
