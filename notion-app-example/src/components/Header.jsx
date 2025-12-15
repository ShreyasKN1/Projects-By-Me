

import React from "react"

export default function Header({search, setSearch, darkMode, setDarkMode }){
return (
    <div className="header">
      <input
        type="text"
        placeholder="Search pages..."
        value={search}
        onChange={(e) => setSearch(e.target.value)}
        className="search-input"
      />
     <button className="btn" onClick={() => setDarkMode(!darkMode)}>
        {darkMode ? "Light Mode" : "Dark Mode"}
      </button>
    </div>
  );
}