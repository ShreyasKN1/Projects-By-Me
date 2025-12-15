
import React from "react"

export default function Editor({ page, updatePage}){
    return (
    <div className="editor">
      <input
        type="text"
        className="title-input"
        value={page.title}
        onChange={(e) => updatePage(page.id, "title", e.target.value)}
      />
      <textarea
        className="content-input"
        value={page.content}
        onChange={(e) => updatePage(page.id, "content", e.target.value)}
        placeholder="Start writing here..."
      />
    </div>
  );
}