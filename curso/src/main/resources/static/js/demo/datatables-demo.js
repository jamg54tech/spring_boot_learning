// Call the dataTables jQuery plugin
$(document).ready(function() {
  console.log("SI ENTRA")
  cargarUsuarios();
  $('#dataTable').DataTable();
});

async function cargarUsuarios(){
  const rawResponse = await fetch('api/usuario', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    //body: JSON.stringify({a: 1, b: 'Textual content'})
  });
  const usuarios = await rawResponse.json();

   let fullHTML="";
  for(let usuario of usuarios){
    let usuarioHTML=`
          <tr>
            <td>${usuario.id}</td>
            <td>${usuario.nombre}</td>
            <td>${usuario.email}</td>
            <td>${usuario.telefono}</td>
            <td>
                <a href="#" onclick="eliminarUsuario(${usuario.id})" class="btn btn-danger btn-circle btn-sm">
                    <i class="fas fa-trash"></i>
                </a>
            </td>
        </tr>
      `;
    fullHTML+=usuarioHTML;
  }


  document.querySelector("#dataTable tbody").outerHTML=fullHTML;
  console.log(content);
}

async function eliminarUsuario(id){
    const rawResponse = await fetch('api/usuario/'+id, {
        method: 'DELETE',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        //body: JSON.stringify({a: 1, b: 'Textual content'})
      });

      location.reload();
}