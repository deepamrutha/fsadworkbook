
import React,{useEffect,useState} from "react";

function UserList(){

 const [users,setUsers] = useState([]);
 const [loading,setLoading] = useState(true);
 const [error,setError] = useState(null);

 useEffect(()=>{
 fetch("https://jsonplaceholder.typicode.com/users")
 .then(res=>res.json())
 .then(data=>{
   setUsers(data);
   setLoading(false);
 })
 .catch(()=>{
   setError("API Error");
   setLoading(false);
 });
 },[]);

 if(loading) return <p>Loading...</p>;
 if(error) return <p>{error}</p>;

 return(
 <div>
 <h3>Users API</h3>

 <table>
 <thead>
 <tr>
 <th>Name</th>
 <th>Email</th>
 <th>Phone</th>
 </tr>
 </thead>

 <tbody>
 {users.map(u=>(
 <tr key={u.id}>
 <td>{u.name}</td>
 <td>{u.email}</td>
 <td>{u.phone}</td>
 </tr>
 ))}
 </tbody>

 </table>

 </div>
 );
}

export default UserList;
