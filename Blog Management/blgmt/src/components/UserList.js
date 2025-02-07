import {useState,useEffect} from 'react';


import './UserList.css';
import { getUsers } from '../api/apiService';

export const userList=()=>{
    const [users, setUsers] = useState([]);

    useEffect=(()=>
    {
        getUsers()
        .then((response)=>{
            setUsers(response.data)
        })
        .catch((error)=>{
            console.log(error)
        })
    },[]);



return (
    <>
    <div className="user-list-container">
            <h2>User List</h2>
            <ul>
                {users.map(user => (
                    <li key={user.id}>
                        <span>{user.username}</span>
                        <span>{user.email}</span>
                    </li>
                ))}
            </ul>
        </div>
    </>
);
};

