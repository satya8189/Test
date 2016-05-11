$.getScript('http://arshaw.com/js/fullcalendar-1.6.4/fullcalendar/fullcalendar.min.js',function(){
  
  var date = new Date();
  var d = date.getDate();
  var m = date.getMonth();
  var y = date.getFullYear();
  
  $('#calendar').fullCalendar({
    header: {
      left: 'prev,next today',
      center: 'title',
      right: 'month,agendaWeek,agendaDay'
    },
    editable: true,
    events: [
      {
        title: '9:30 PM to 10:30 PM',
        start: new Date(y, m, 1)
      },
      {
        title: '10:30 PM to 11:30 PM',
        start: new Date(y, m, d-5),
        end: new Date(y, m, d-2)
      },
      {
        id: 999,
        title: '9:30 PM to 10:30 PM',
        start: new Date(y, m, d-3, 16, 0),
        allDay: false
      },
      {
        id: 999,
        title: '9:30 PM to 10:30 PM',
        start: new Date(y, m, d+4, 16, 0),
        allDay: false
      },
      {
        title: '9:30 PM to 10:30 PM',
        start: new Date(y, m, d, 10, 30),
        allDay: false
      },
      {
        title: '9:30 PM to 10:30 PM',
        start: new Date(y, m, d, 12, 0),
        end: new Date(y, m, d, 14, 0),
        allDay: false
      },
      {
        title: '11:30 PM to 12:30 AM',
        start: new Date(y, m, d+1, 19, 0),
        end: new Date(y, m, d+1, 22, 30),
        allDay: false
      },
      {
        title: '11:30 PM to 12:30 AM',
        start: new Date(y, m, 28),
        end: new Date(y, m, 29),
       /* url: 'http://google.com/'*/
      }
    ]
  });
})