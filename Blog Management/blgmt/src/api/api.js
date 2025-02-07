import axios from 'axios';


const url='http://localhost/3306/blogdb';

export const getUsers=()=>{
    axios.get(`${url}/users`)
    .then((response)=>
    {
        console.log(response.data);
    });

}

export const getUserById=(id)=>{
    axios.get(`${url}/users/${id}`)
    .then((response)=>
    {
        console.log(response.data);
    });

}

export const createUser=(user)=>{
    axios.post(`${url}/users`,user);
}


export const updateUser=(id,user)=>{
    axios.put(`${url}/users/${id}`,user);
}

export const deleteUser=(id)=>{
    axios.delete(`${url}/users/${id}`)
    .then((response)=>{
        console.log(response.data+"deleted successfully")
    });
}

export const getAllPosts=()=>{
    axios.get(`${url}/posts`)
    .then((response)=>{
        console.log(response.data)
    });
}


export const getPostById=(id)=>{
    axios.get(`${url}/posts/${id}`)
    .then((response)=>{
        console.log(response.data)
    });
}

export const createPost=(post)=>{
    axios.post(`${url}/posts`,post);
}

export const updatePost=(id,post)=>{
    axios.put(`${url}/posts/${id}`,post);
}

export const deletePost=(id)=>{
    axios.delete(`${url}/posts/${id}`)
    .then((response)=>{
        console.log(response.data +"deleted successfully");
    })
}

export const createComment = (comment) =>{
    axios.post(`${url}/comments`, comment);
} 


export const getCommentsByPostId = (postId) =>{

    axios.get(`${url}/comments?postId=${postId}`)
    .then((response)=>{
        console.log(response.data);
    });
} 