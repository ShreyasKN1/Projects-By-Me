//@flow

import React from "react";

export default function Sidebar({pages,activePageId,setActivePageId,addPage,deletePage,movePage}){

    return (
    <div className="sidebar">
      <h2 className="sidebar-title">Workspaces</h2>
      <button className="btn" onClick={addPage}>+ Adding new Page</button>
      <ul className="page-list">
        {pages.map((p, index) => (
          <li
            key={p.id}
            className={`page-item ${p.id === activePageId ? "active" : ""}`}
            onClick={() => setActivePageId(p.id)}
          >
            <span>{p.title}</span>
            <div className="page-actions">
              <button onClick={(e) => { e.stopPropagation(); movePage(index, -1); }}>↑</button>
              <button onClick={(e) => { e.stopPropagation(); movePage(index, 1); }}>↓</button>
              <button onClick={(e) => { e.stopPropagation(); deletePage(p.id); }}>✕</button>
            </div>
          </li>
        ))}
      </ul>
    </div>
    );
}