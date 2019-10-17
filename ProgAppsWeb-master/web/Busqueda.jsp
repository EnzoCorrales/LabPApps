<%-- 
    Document   : Busqueda
    Created on : Oct 13, 2019, 5:58:30 PM
    Author     : kangaru
--%>

<%@page import="Controladores.Sistema"%>
<%@page import="Entidades.Fecha"%>
<%@page import="java.util.*"%>
<%@page import="DT.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String ord = (String) request.getAttribute("ord");
            String filtro = (String) request.getAttribute("filtro");
            
            if(ord.equalsIgnoreCase("Opcion")){
                if(filtro.equalsIgnoreCase("Opcion")){
                    ArrayList<String> resul = (ArrayList<String>) request.getAttribute("Resultados");
                    session.setAttribute("Resultados", null);
                    session.setAttribute("Resultados", resul);
                }
                else if(filtro.equalsIgnoreCase("Videos")){
                    ArrayList<String> videos = (ArrayList<String>) request.getAttribute("ListaVideos");
                    session.setAttribute("Resultados", null);
                    session.setAttribute("Resultados", videos);
                }
                else if(filtro.equalsIgnoreCase("Listas")){
                    ArrayList<String> listas = (ArrayList<String>) request.getAttribute("ListaLR");
                    session.setAttribute("Resultados", null);
                    session.setAttribute("Resultados", listas);
                }
                else if(filtro.equalsIgnoreCase("Canales")){
                    ArrayList<String> canales = (ArrayList<String>) request.getAttribute("ListaCanales");
                    session.setAttribute("Resultados", null);
                    session.setAttribute("Resultados", canales);
                }
            }
            
            if(ord.equalsIgnoreCase("Alfabeticamente")){
                if(filtro.equalsIgnoreCase("Opcion")){
                    ArrayList<String> r = (ArrayList<String>) request.getAttribute("Resultados");
                    Collections.sort(r);
                    session.setAttribute("Resultados", null);
                    session.setAttribute("Resultados", r);
                }
                else if(filtro.equalsIgnoreCase("Videos")){
                    ArrayList<String> videos = (ArrayList<String>) request.getAttribute("ListaVideos");
                    Collections.sort(videos);
                    session.setAttribute("Resultados", null);
                    session.setAttribute("Resultados", videos);
                }
                else if(filtro.equalsIgnoreCase("Listas")){
                    ArrayList<String> lr = (ArrayList<String>) request.getAttribute("ListaLR");
                    Collections.sort(lr);
                    session.setAttribute("Resultados", null);
                    session.setAttribute("Resultados", lr);
                }
                else if(filtro.equalsIgnoreCase("Canales")){
                    ArrayList<String> canales = (ArrayList<String>) request.getAttribute("ListaCanales");
                    Collections.sort(canales);
                    session.setAttribute("Resultados", null);
                    session.setAttribute("Resultados", canales);
                }
            }
            
            if(ord.equalsIgnoreCase("Anio")){
                if(filtro.equalsIgnoreCase("Opcion")){
                    
                }
                else if(filtro.equalsIgnoreCase("Videos")){
                    ArrayList<DtVideo> r = (ArrayList<DtVideo>) request.getAttribute("Videos");
                    DtVideo[] arreglo = new DtVideo[r.size()];
                    for(int i = 0; i < r.size(); i++){
                        arreglo[i] = r.get(i);
                    }
                    DtVideo[] ordenado = new DtVideo[r.size()];
                    Collection<String> resu = new ArrayList<>();
                    DtVideo aux;
                    for(int i = 2; i < arreglo.length; i++){
                        for(int j = 0; j < arreglo.length - i; j++){
                            //if(!arreglo[j].getFecha().Mayor(arreglo[j+1].getFecha())){
                                aux = arreglo[j];
                                arreglo[j] = arreglo[j+1];
                                arreglo[j+1] = aux;
                            //}
                        }
                    }
                    ordenado = arreglo;
                    String[] arr = new String[ordenado.length];
                    for(int i = 0; i < ordenado.length; i++){
                        arr[i] = ordenado[i].getNomVideo();
                    }
                    Collections.addAll(resu, arr);
                    session.setAttribute("Resultados", null);
                    session.setAttribute("Resultados", resu);
                }
                else if(filtro.equalsIgnoreCase("Listas")){
                    ArrayList<DtLR> r = (ArrayList<DtLR>) request.getAttribute("Listas");
                    Sistema s = Sistema.getInstance();
                    ArrayList<DtVideo> video = new ArrayList<>();
                    Iterator<DtLR> it = r.iterator();
                    while(it.hasNext()){
                        DtLR dt = it.next();
                        //if(s.TieneVideosLR(dt.getCategoria()))
                            //video.add(s.OrdenoVideosLR(dt.getCategoria()));
                    }
                    DtVideo[] arreglo = new DtVideo[video.size()];
                    for(int i = 0; i < video.size(); i++){
                        arreglo[i] = video.get(i);
                    }
                    DtVideo[] ordenado = new DtVideo[video.size()];
                    DtVideo aux;
                    for(int i = 2; i < arreglo.length; i++){
                        for(int j = 0; j < arreglo.length - i; j++){
                            //if(!arreglo[j].getFecha().Mayor(arreglo[j+1].getFecha())){
                                aux = arreglo[j];
                                arreglo[j] = arreglo[j+1];
                                arreglo[j+1] = aux;
                            //}
                        }
                    }
                    ordenado = arreglo;
                    Collection<DtVideo> arr = new ArrayList<>();
                    Collections.addAll(arr,ordenado);
                    Collection<String> li = new ArrayList<>();
                    Iterator<DtVideo> it2 = arr.iterator();
                    while(it2.hasNext()){
                        DtVideo v = it2.next();
                        it = r.iterator();
                        while(it.hasNext()){
                            DtLR dlr = it.next();
                            //if(s.ExisteVideoLR(v.getId(), dlr.getId())){
                                li.add(dlr.getNombre());
                            //}
                        }
                    }
                    session.setAttribute("Resultados", null);
                    session.setAttribute("Resultados", li);
                }
                else if(filtro.equalsIgnoreCase("Canales")){
                    /*ArrayList<DtCanal> r = (ArrayList<DtCanal>) request.getAttribute("Canales");
                    DtCanal[] arreglo = new DtCanal[r.size()];
                    for(int i = 0; i < r.size(); i++){
                        arreglo[i] = r.get(i);
                    }
                    DtCanal[] ordenado = new DtCanal[r.size()];
                    Collection<String> resu = new ArrayList<>();
                    DtCanal aux;
                    for(int i = 2; i < arreglo.length; i++){
                        for(int j = 0; j < arreglo.length - i; j++){
                            if(arreglo[j].getFecha().Mayor(arreglo[j+1].getFecha())){
                                aux = arreglo[j];
                                arreglo[j] = arreglo[j+1];
                                arreglo[j+1] = aux;
                            }
                        }
                    }
                    ordenado = arreglo;
                    String[] arr = new String[ordenado.length];
                    for(int i = 0; i < ordenado.length; i++){
                        arr[i] = ordenado[i].getNombre();
                    }
                    Collections.addAll(resu, arr);
                    session.setAttribute("Resultados", resu);*/
                }
            }
        %>
        <div class="Iframes">
            <iframe id="iFrame" name="iFrame" width="98%" height="700" src="TBusqueda.jsp" ></iframe>
        </div>
    </body>
</html>
