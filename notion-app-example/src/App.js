import React,{useState,useEffect} from "react";
import Sidebar from "./components/Sidebar";
import Editor from "./components/Editor";
import Header from "./components/Header";
import "./index.css";

export default function App() {


  const [pages,setPages]=useState(()=>
  {
    const saved=localStorage.getItem("pages")
    return saved? JSON.parse(saved):[{ id: 1, title: "First Note", content: "" }];
  });

  const [activePageId,setActivePageId]=useState(pages[0].id);

  const [darkMode,setDarkMode]=useState(false);


  const[search,setSearch]=useState("");

  useEffect(()=>
  {
    localStorage.setItem("pages",JSON.stringify(pages));
  },[pages]);

  useEffect(() => {
    if (darkMode) {
      document.body.classList.add("dark");
    } else {
      document.body.classList.remove("dark");
    }
  }, [darkMode]);

  //add new page id being created now
  const addPage=()=>{
    const newPage={
      id: Date.now(),
      title: "Untitled",
      content: ""
    };
    setPages([...pages,newPage]);
    setActivePageId(newPage.id);
  }

  //deleting pages based on id
  const deletePage=(id)=>{
    const updated=pages.filter((p)=> p.id!==id);
    setPages(updated);
    if(updated.length>0)
    {
      setActivePageId(updated[0].id); // pick the first remaining page
      } else {
     setActivePageId(null); //// no pages left
    }
  }


  //One of the best ways of moving pages like in easier coding ways
  const movePages=(index,direction)=>{
    const newPages=[...pages];
    const targetIndex=index+direction; //direction either +1 or -1
    if (targetIndex < 0 || targetIndex >= newPages.length) return; //outofbounds
    const temp = newPages[index];
    newPages[index] = newPages[targetIndex];
    newPages[targetIndex] = temp;
    setPages(newPages);
  }


  //onlyforupdating certain things in page use filter and map
  const updatePages=(id,field,value)=>{
    setPages(
      pages.map((p) =>
        p.id === id ? { ...p, [field]: value } : p //new uodated value or keep the page same
      )
    );
  }

  // Filter pages by searching theitr titles
  const filteredPages = pages.filter((p) =>
    p.title.toLowerCase().includes(search.toLowerCase())
  );

  const activePage = pages.find((p) => p.id === activePageId);



  return (
   <div style={{ display: "flex", height: "100vh" }}>
      <Sidebar
        pages={filteredPages}
        activePageId={activePageId}
        setActivePageId={setActivePageId}
        addPage={addPage}
        deletePage={deletePage}
        movePage={movePages}
      />
      <div style={{ flex: 1, display: "flex", flexDirection: "column" }}>
        <Header
          search={search}
          setSearch={setSearch}
          darkMode={darkMode}
          setDarkMode={setDarkMode}
        />
        {activePage ? (
          <Editor page={activePage} updatePage={updatePages} />
        ) : (
          <div style={{ padding: "20px" }}>Select or add a page</div>
        )}
      </div>
    </div>
  );
}
