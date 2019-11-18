<div class='book'>
    <h2>${book.title}</h2>
    <book:price price="${book.price}"/>
    <a href="<g:createLink controller="example" action="tagLibs" params="${[id:book.id]}"/>">BUY</a>
</div>