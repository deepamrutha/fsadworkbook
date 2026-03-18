import React,{useState,useEffect} from 'react';
import axios from 'axios';

function App(){
const [students,setStudents]=useState([]);
const [form,setForm]=useState({name:'',email:'',course:''});
const [editId,setEditId]=useState(null);

const load=()=>{axios.get('http://localhost:8080/students').then(res=>setStudents(res.data));}
useEffect(()=>{load();},[]);

const handleChange=e=>setForm({...form,[e.target.name]:e.target.value});

const save=()=>{
if(editId){
axios.put(`http://localhost:8080/students/${editId}`,form).then(()=>{load();setEditId(null);});
}else{
axios.post('http://localhost:8080/students',form).then(load);
}
setForm({name:'',email:'',course:''});
}

const del=id=>axios.delete(`http://localhost:8080/students/${id}`).then(load);
const edit=s=>{setForm(s);setEditId(s.id);}

return(
<div>
<h2>Student Manager</h2>
<input name='name' placeholder='Name' value={form.name} onChange={handleChange}/>
<input name='email' placeholder='Email' value={form.email} onChange={handleChange}/>
<input name='course' placeholder='Course' value={form.course} onChange={handleChange}/>
<button onClick={save}>Save</button>

<table border='1'>
<thead><tr><th>ID</th><th>Name</th><th>Email</th><th>Course</th><th>Action</th></tr></thead>
<tbody>
{students.map(s=>(
<tr key={s.id}>
<td>{s.id}</td><td>{s.name}</td><td>{s.email}</td><td>{s.course}</td>
<td>
<button onClick={()=>edit(s)}>Edit</button>
<button onClick={()=>del(s.id)}>Delete</button>
</td>
</tr>
))}
</tbody>
</table>
</div>
);
}
export default App;
