function tree_toggle(event) {
    event = event || window.event
    var clickedElem = event.target || event.srcElement

    if (!hasClass(clickedElem, 'Expand')) {
        return // клик не там
    }

    // Node, на который кликнули
    var node = clickedElem.parentNode
    if (hasClass(node, 'ExpandLeaf')) {
        return // клик на листе
    }

    // определить новый класс для узла
    var newClass = hasClass(node, 'ExpandOpen') ? 'ExpandClosed' : 'ExpandOpen'
    // заменить текущий класс на newClass
    // регексп находит отдельно стоящий open|close и меняет на newClass
    var re =  /(^|\s)(ExpandOpen|ExpandClosed)(\s|$)/
    node.className = node.className.replace(re, '$1'+newClass+'$3')
}


function hasClass(elem, className) {
    return new RegExp("(^|\\s)"+className+"(\\s|$)").test(elem.className)
}
