
import React,{useEffect,useState} from "react";
import axios from "axios";

function FakePostList(){

 const [posts,setPosts] = useState([]);
 const [filtered,setFiltered] = useState([]);
 const [userId,setUserId] = useState("all");

 const loadPosts=()=>{
 axios.get("https://dummyjson.com/posts")
 .then(res=>{
   setPosts(res.data.posts);
   setFiltered(res.data.posts);
 });
 };

 useEffect(()=>{
 loadPosts();
 },[]);

 const filterPosts=(value)=>{

 setUserId(value);

 if(value==="all"){
 setFiltered(posts);
 }else{
 setFiltered(posts.filter(p=>p.userId===Number(value)));
 }

 };

 return(
 <div>

 <h3>Fake API Posts</h3>

 <button onClick={loadPosts}>Refresh</button>

 <div>
 <label>Filter by UserId:</label>

 <select value={userId} onChange={(e)=>filterPosts(e.target.value)}>
 <option value="all">All</option>
 <option value="1">1</option>
 <option value="2">2</option>
 <option value="3">3</option>
 </select>

 </div>

 <ul>
 {filtered.map(p=>(
 <li key={p.id}>
 <strong>{p.title}</strong>
 <p>{p.body}</p>
 </li>
 ))}
 </ul>

 </div>
 );
}

export default FakePostList;
