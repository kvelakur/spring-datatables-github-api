$(document).ready(function () {
  $('#example').DataTable({
    "processing": true,
    "serverSide": true,
    "ajax": "githubRepos",
    searchDelay: 1000,
    "order": [[3, 'desc']],
    "language" : {  searchPlaceholder: "tetris" },
    "columns": [
      {"data": "full_name", "orderable": false},
      {"data": "description", "orderable": false},
      {"data": "html_url", "orderable": false},
      {"data": "forks_count"},
      {"data": "watchers_count", "orderable": false},
      {"data": "stargazers_count"}
    ]
  });
});
